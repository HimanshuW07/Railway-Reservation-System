import { Component, OnInit } from '@angular/core';
import { FormControl, FormGroup, Validators } from '@angular/forms';
import { Router } from '@angular/router';
import { Register } from 'src/app/register';
import { RegisterService } from '../register.service';

@Component({
  selector: 'app-register',
  templateUrl: './register.component.html',
  styleUrls: ['./register.component.css']
})
export class RegisterComponent implements OnInit {

  exform: FormGroup;
   
  register : Register = new Register(); 

  constructor(  private registerService: RegisterService,  
    private router:Router) { }

  ngOnInit() {
    this.exform = new FormGroup({
      'userName' : new FormControl(null, Validators.required),
      'userFirstName' : new FormControl(null, Validators.required),
    });
  }
  
  
  saveUser(){ 
    this.registerService.userRegistration(this.register).subscribe( data => { 
      console.log(data); 
      this. goToHome(); 
    }, 
    error => console.log(error)); 
  } 
 
  goToHome(){ 
      this.router.navigate(['/home']); 
  } 
 
  onSubmit(){ 
    console.log(this.register); 
    this.saveUser(); 
  } 
 
}
