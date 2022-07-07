import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Train } from './train';

// export class Trains {
//   constructor(
//    public  trainNo: String,
// 	  public  trainName: String,
// 	  public  trainFrom: String,
// 	  public  trainTo: String,
// 	  public  fare: number,
// 	  public  seats: number,
// 	  public  time: String
//   ) {
//   }
// }

@Injectable({
  providedIn: 'root'
})
export class TraindataService {
  [x: string]: any;
  getTrainByNo: any;
  updateTrains(trainNo: String, train: Train) {
    throw new Error('Method not implemented.');
  }

  constructor(private http:HttpClient) { }

  public getTrains() {
    return this.http.get("http://localhost:8083/api/viewalltrains");
  }

  public deleteTrain(trainNo:any){
    return this.http.delete("http://localhost:8083/api/deletetrain/"+trainNo);
  }

  public addNew(train:any) {
    return this.http.post("http://localhost:8083/api/addtrain", train, { responseType: "text" as "json" });
  }

  getTrainsbyfrom(trainFrom:any) {
    return this.http.get("http://localhost:8083/api/findfrom/"+trainFrom);
  }

  getTrainsbyto(trainTo:any) {
    return this.http.get("http://localhost:8083/api/findto/"+trainTo);
  }

  getTrainsbw(fromTrain:any,toTrain:any) {
    return this.http.get("http://localhost:8083/api/findbw/"+fromTrain+'/'+toTrain);

  }

}