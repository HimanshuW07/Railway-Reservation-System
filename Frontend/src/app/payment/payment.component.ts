import { Component, OnInit } from '@angular/core';
import { AuthService } from '../auth.service';

@Component({
  selector: 'app-payment',
  templateUrl: './payment.component.html',
  styleUrls: ['./payment.component.css']
})
export class PaymentComponent implements OnInit {
  title = 'Creative Developer';
  constructor(private auth: AuthService) { }

  ngOnInit(): void {
  }

  options = {
    "key": "rzp_test_L7GdfnKTEbB7a1", // Enter the Key ID generated from the Dashboard
    "amount": "6000", // Amount is in currency subunits. Default currency is INR. Hence, 50000 refers to 50000 paise
    "currency": "INR",
    "name": "Book your Ticket",
    "description": "Test Transaction",
    "image": "https://example.com/your_logo",
    "order_id": "", //This is a sample Order ID. Pass the `id` obtained in the response of Step 1
    "callback_url": "https://eneqd3r9zrjok.x.pipedream.net/",
    "prefill": {
        "name": "Himanshu Wakade",
        "email": "lucifertrek361@gmail.com",
        "contact": "9173824650"
    },
    "notes": {
        "address": "Razorpay Corporate Office"
    },
    "theme": {
        "color": "#3399cc"
    }
};

rzp1: any;
pay(){
  this.rzp1 = new this.auth.nativeWindow.Razorpay(this.options);

  this.rzp1.open();
}
}
