//
//
//import static org.junit.jupiter.api.Assertions.assertEquals;
//import static org.mockito.Mockito.times;
//import static org.mockito.Mockito.verify;
//import static org.mockito.Mockito.when;
//
//import java.util.stream.Collectors;
//import java.util.stream.Stream;
//
//import com.example.micro.TrainDetails.controller.TrainController;
//import com.example.micro.TrainDetails.model.TrainModel;
//import com.example.micro.TrainDetails.repository.TrainRepository;
//import org.junit.jupiter.api.DisplayName;
//import org.junit.jupiter.api.Test;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.boot.test.context.SpringBootTest;
//import org.springframework.boot.test.mock.mockito.MockBean;
//
//
//@SpringBootTest
//class TrainControllerTests {
//
//    @Autowired
//    TrainController trainController;
//
//    @MockBean
//    TrainRepository trainsrepository;
//
//    @Test
//    @DisplayName("adding")
//    public void saveTicketTest() {
//        TrainModel train = new TrainModel("6215","6215","12","Sahiwal","Karachi","1:25pm","","");
//        when(trainsrepository.save(train)).thenReturn(train);
//        assertEquals("Added Ticket with id:6215", trainController.saveTicket(train));
//
//    }
//
//
//    @Test
//    @DisplayName("viewalltrains")
//    public void getTrainTest() {
//        when(trainsrepository.findAll()).thenReturn(Stream
//                .of(new TrainModel("1456","ED3","3","Multan",5,4,"22","1"),
//                        new  TrainModel("1243","JP8","7","Karachi",3,2,"22","1"),
//                        new TrainModel("33456","87F","10","Multan",1,8,"22","1")).collect(Collectors.toList()));
//        assertEquals(3,trainController.getAllTrains().size()); }
//
//}
