import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { AddServiceCenterComponent } from './add-service-center/add-service-center.component';
import { AdminMainComponent } from './admin-main/admin-main.component';
import { LoginComponent } from './login/login.component';
import { ServiceCenterComponent } from './service-center/service-center.component';

const routes: Routes = [
  { path: 'login', component: LoginComponent },
  { path: 'adminHomePage', component: AdminMainComponent },
  { path: 'serviceCenter', component: ServiceCenterComponent },
  { path: 'serviceCenter/new', component: AddServiceCenterComponent },
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
