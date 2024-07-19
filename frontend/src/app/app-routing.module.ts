import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import {LoginComponent} from "./components/login/login.component";
import {AdminTemplateComponent} from "./components/admin-template/admin-template.component";
import {AuthGuard} from "./guards/auth.guard";
import {HomeComponent} from "./components/home/home.component";
import {ProfileComponent} from "./components/profile/profile.component";
import {PaymentsComponent} from "./components/payments/payments.component";
import {StudentComponent} from "./components/student/student.component";
import {AuthorizationGuard} from "./guards/authorization.guard";
import {LoadPaymentsComponent} from "./components/load-payments/load-payments.component";
import {LoadStudentsComponent} from "./components/load-students/load-students.component";

const routes: Routes = [
  {path : "", component : LoginComponent},
  {path : "login", component : LoginComponent},
  {path : "admin", component : AdminTemplateComponent,
    canActivate : [AuthGuard],
    children : [
      {path : "home", component : HomeComponent},
      {path : "profile", component : ProfileComponent},
      {path : "students", component : StudentComponent},
      {path : "payments", component : PaymentsComponent},
      {
        path : "loadStudents", component : LoadStudentsComponent,
        canActivate : [AuthorizationGuard], data : {roles : ['ADMIN']}
      },
      {
        path : "loadPayments", component : LoadPaymentsComponent,
        canActivate : [AuthorizationGuard], data : {roles : ['ADMIN']}
      },
    ]},

];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
