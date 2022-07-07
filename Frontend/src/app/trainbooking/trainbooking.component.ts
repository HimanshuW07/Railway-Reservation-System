import { Component, OnInit } from '@angular/core';
import { BookService } from '../book.service';
import { Book } from '../book';
import { FormControl, FormGroup, Validators } from '@angular/forms';

@Component({
  selector: 'app-train-booking',
  templateUrl: './trainbooking.component.html',
  styleUrls: ['./trainbooking.component.css']
})
export class TrainbookingComponent implements OnInit {

  exform: FormGroup;

  [x: string]: any;

  book:Book =new Book();

  constructor(private bookService: BookService) { }

  ngOnInit() {

    this.exform = new FormGroup({
      'trainName' : new FormControl(null, Validators.required),
      'fare' : new FormControl(null, Validators.required),
    });
  }


  bookTrain(){
    console.log(this.book);
    this.bookService.TrainBooking(this.book).subscribe(data=>{
          alert("Booking Confirmed Successfully")
    },error=>alert("Oops! there is something wrong"));
  }
}

