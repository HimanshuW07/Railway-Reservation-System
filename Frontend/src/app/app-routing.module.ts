import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';
import { AdminComponent } from './admin/admin.component';
import { ForbiddenComponent } from './forbidden/forbidden.component';
import { HomeComponent } from './home/home.component';
import { LoginComponent } from './login/login.component';
import { UserComponent } from './user/user.component';
import { AuthGuard } from './_auth/auth.guard';
import { SearchtrainsComponent } from './searchtrains/searchtrains.component';
import { AddtrainsComponent } from './addtrains/addtrains.component';
import { ManagetrainsComponent } from './managetrains/managetrains.component';
import { TicketbookComponent } from './ticketbook/ticketbook.component';
import { TrainbookingComponent } from './trainbooking/trainbooking.component';
import { PaymentComponent } from './payment/payment.component';
import { AboutUsComponent } from './about-us/about-us.component';
import { RegisterComponent } from './register/register.component';
import { UpdatetrainsComponent } from './updatetrains/updatetrains.component';


const routes: Routes = [
  {path: '',redirectTo: 'home', pathMatch: 'full'},
  { path: 'home', component: HomeComponent },
  { path: 'register', component: RegisterComponent },
  { path: 'searchtrains', component: SearchtrainsComponent },
  { path: 'about-us', component: AboutUsComponent },
  { path: 'addtrains', component: AddtrainsComponent },
  { path: 'updatetrains', component: UpdatetrainsComponent },
  { path: 'managetrains', component: ManagetrainsComponent },
  { path: 'admin', component: AdminComponent, canActivate:[AuthGuard], data:{roles:['Admin']} },
  { path: 'user', component: UserComponent ,  canActivate:[AuthGuard], data:{roles:['User']} },
  { path: 'login', component: LoginComponent },
  { path: 'ticketbook', component: TicketbookComponent },
  { path: 'trainbooking', component: TrainbookingComponent },
  { path: 'payment', component: PaymentComponent },
  { path: 'forbidden', component: ForbiddenComponent }
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule],
})
export class AppRoutingModule {}
