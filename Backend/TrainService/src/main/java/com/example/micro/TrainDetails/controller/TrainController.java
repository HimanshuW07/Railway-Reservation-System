package com.example.micro.TrainDetails.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.micro.TrainDetails.repository.TrainRepository;
import com.example.micro.TrainDetails.model.BookingModel;
import com.example.micro.TrainDetails.model.TrainModel;


@CrossOrigin(origins = "http://localhost:4200")
@Transactional
@RestController
@RequestMapping("/api")
public class TrainController {
	
	@Autowired
	TrainRepository trainrepo;




	//	Author: Himanshu Wakade
    //	Date: 15/04/2022
    //	Modified: 21/04/2022
    //	Desc: Implemented logger method on post request method of adding train

	Logger logger = LoggerFactory.getLogger(TrainController.class);

	@PostMapping("/addtrain")
	public void addtrain(@RequestBody TrainModel trainmodel) {
		logger.info("[postTrain] info train");
		logger.warn("[postTrain] warn train");
		logger.error("[postTrain] error train");
		logger.debug("[postTrain] debug train");
		logger.trace("[postTrain] trace train");
		trainrepo.save(trainmodel);
		
	}


	//	Author: Himanshu Wakade
	//	Date: 15/04/2022
	//	Modified: 21/04/2022
	//	Desc: Implemented get method on viewing all trains

	@GetMapping("/viewalltrains")
	public List<TrainModel> getAllTrains()
	{
		return trainrepo.findAll();
	}



	//	Author: Himanshu Wakade
	//	Date: 15/04/2022
	//	Modified: 21/04/2022
	//	Desc: Implemented get method on viewing all trains by train number

	@GetMapping("/viewtrainbyno/{trainNo}")
	public TrainModel getTrains(@PathVariable("trainNo") String trainNo)
	{
		return trainrepo.findByTrainNo(trainNo);
	}



	//	Author: Himanshu Wakade
	//	Date: 15/04/2022
	//	Modified: 21/04/2022
	//	Desc: Implemented get method on viewing all trains by name

	@GetMapping("/viewtrainbyname/{trainName}")
	public List<TrainModel> getTrainsbyname(@PathVariable("trainName") String trainName)
	{
		return trainrepo.findByTrainName(trainName);		
	}



	//	Author: Himanshu Wakade
	//	Date: 15/04/2022
	//	Modified: 21/04/2022
	//	Desc: Implemented update method for updating train by its number

	@PutMapping(value="/updatetrain/{trainNo}")
	public String update(@PathVariable("trainNo") String trainNo, @RequestBody TrainModel trainmodel) {
		trainrepo.save(trainmodel);
		return "Train with no. "+trainNo+" have been updated successfully";
	}




	//	Author: Himanshu Wakade
	//	Date: 15/04/2022
	//	Modified: 21/04/2022
	//	Desc: Implemented delete method on train by its train no

	Logger logger1 = LoggerFactory.getLogger(TrainController.class);

	@CrossOrigin
	@DeleteMapping("/deletetrain/{trainNo}")
	
	public void delete(@PathVariable String trainNo)
	{
		logger1.info("[deleteTrain] info train");
		logger1.warn("[deleteTrain] warn train");
		logger1.error("[deleteTrain] error train");
		logger1.debug("[deleteTrain] debug train");
		logger1.trace("[deleteTrain] trace train");
		TrainModel obj = new TrainModel();
		obj=trainrepo.findByTrainNo(trainNo);
		trainrepo.delete(obj);
	}


	@GetMapping("/findfrom/{trainFrom}")
	public List<TrainModel> findByfrom(@PathVariable("trainFrom") String trainFrom)
	{
		return trainrepo.findByTrainFrom(trainFrom);
	}
	
	@GetMapping("/findto/{trainTo}")
	public List<TrainModel> findByto(@PathVariable("trainTo") String trainTo)
	{
		return trainrepo.findByTrainTo(trainTo);
	}
	


	@GetMapping("/findfarebyno/{trainNo}")
	public int findfare(@PathVariable("trainNo") String trainNo)
	{
		return trainrepo.findByTrainNo(trainNo).getFare();
	}



	@PostMapping("/decreaseseat/{trainNo}/{seats}")
	public void decreaseseats(@PathVariable("trainNo") String trainNo, @PathVariable("seats") int seats, @RequestBody BookingModel bookmodel)
	{
		TrainModel obj = new TrainModel();
		obj=trainrepo.findByTrainNo(trainNo);
		int temp = obj.getSeats();
		obj.setSeats(temp-seats);
		trainrepo.save(obj);
	}


	
	@PostMapping("/increaseseat/{trainNo}/{seats}")
	public void increaseseats(@PathVariable("trainNo") String trainNo, @PathVariable("seats") int seats)
	{
		TrainModel obj = new TrainModel();
		obj=trainrepo.findByTrainNo(trainNo);
		int temp = obj.getSeats();
		obj.setSeats(temp+seats);
		trainrepo.save(obj);
	}


	@GetMapping("/findtimebyno/{trainNo}")
	public String findtimebyno(@PathVariable("trainNo") String trainNo)
	{
		return trainrepo.findByTrainNo(trainNo).getTime();
	}


//	@GetMapping("/findtimebyname/{trainName}")
//	public String findtimebyname(@PathVariable("trainName") String trainName)
//	{
//		return trainrepo.findByTrainNo(trainNo).getTime();
//	}
//
}
