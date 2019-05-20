package csv.controller;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;

import org.springframework.web.multipart.MultipartFile;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory; 
import org.springframework.beans.factory.annotation.Autowired; 
import org.springframework.stereotype.Controller;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.view.RedirectView;

import csv.domain.User;
import csv.repository.UserRepository;
  
@Controller  
@RequestMapping(path="/", method={RequestMethod.POST,RequestMethod.GET})	//default path
public class UserController {
	private static final Logger log = LoggerFactory.getLogger(UserController.class);
	
	@Autowired 
	private UserRepository userRepository;
	  
	//index page
	@GetMapping({"/", "/index"})  
	public String index() { 
		return "index";
	} 
	
	@RequestMapping(value="/uploadToDB", method=RequestMethod.POST)
    public RedirectView create(@RequestParam("file") MultipartFile multipartFile) throws IOException {

        log.info("running");
		//Save multipartFile file in a temporary physical folder
        String path = "target/classes/upload/";
        File fileToImport = new File(path + multipartFile.getOriginalFilename());
 
        String filename = StringUtils.cleanPath(multipartFile.getOriginalFilename());
        try {
            if (multipartFile.isEmpty()) {
                throw new IOException("Failed to store empty file " + filename);
            }
            if (filename.contains("..")) {
                // This is a security check
                throw new IOException(
                        "Cannot store file with relative path outside current directory "
                                + filename);
            }
            try (InputStream inputStream = multipartFile.getInputStream()) {
                Files.copy(inputStream, Paths.get(path).resolve(filename),
                    StandardCopyOption.REPLACE_EXISTING); 
            }
            
            try (BufferedReader br = new BufferedReader(new FileReader(fileToImport))) {
            	String line;
                while ((line = br.readLine()) != null) {
                	String[] values = line.split(",");
                        
                    User n = new User();
                	int count = 0;
                    for (String col : values) { 
                    	if (count == 0) { 
                    		n.setName(col);
                        }
                        else if (count == 1) { 
                        	n.setSalary(new Double(col));
                        }
                        count++;
                    } 
                	userRepository.save(n); 
                }
            } 
        }
        catch (IOException e) {
            throw new IOException("Failed to store file " + filename, e);
        }
        
          
        RedirectView redirectView = new RedirectView();
        redirectView.setUrl("/users");
        return redirectView;
    }
	
	//Test sql connection by adding a record
	//$ curl 'localhost:8080/add?name=test&salary=1111'
    @GetMapping(path="/add")
	public @ResponseBody String addUser (@RequestParam String name, @RequestParam Double salary) { 
		User n = new User();
		n.setName(name);
		n.setSalary(salary);
		userRepository.save(n);
		return "Saved";
	}
	
    //$ curl 'localhost:8080/demo/all'
	@GetMapping(path="/users")
	public @ResponseBody Iterable<User> getUsers() {  
		// returns a JSON or XML with the users
		//return userRepository.findAll();
		return userRepository.findSalaryRange(0.0, 4000.0);
	}

}
