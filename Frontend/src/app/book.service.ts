import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable, Observer } from 'rxjs';
import { Book } from './book';

@Injectable({
  providedIn: 'root'
})
export class BookService {
  [x: string]: any;
   baseUrl="http://localhost:8084/booking/add-booking";
   
  constructor(private httpClient: HttpClient) { }


  TrainBooking(book: Book): Observable<Object> {
     console.log(book);
     return this.httpClient.post(`${this.baseUrl}`,book);
  }
}
