package csv.processor;
 
import org.springframework.batch.item.ItemProcessor;

import csv.domain.User;

//To process large amount of data
public class UserItemProcessor implements ItemProcessor<User, User> {
	 @Override
	 public User process(User user) throws Exception {  
	  return user;
	 }

} 