import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { AddCustomerComponent } from './add-customer/add-customer.component';
import { AddEmployeeComponent } from './add-employee/add-employee.component';
import { AddServiceCategoryComponent } from './add-service-category/add-service-category.component';
import { AddServiceCenterComponent } from './add-service-center/add-service-center.component';
import { AdminMainComponent } from './admin-main/admin-main.component';
import { CustomerHomeComponent } from './customer-home/customer-home.component';
import { LoginComponent } from './login/login.component';
import { ManagerHomeComponent } from './manager-home/manager-home.component';
import { MechanicHomeComponent } from './mechanic-home/mechanic-home.component';
import { ServiceCategory } from './models/ServiceCategory';
import { ReceptionistMainComponent } from './receptionist-main/receptionist-main.component';
import { ScheduleBundleComponent } from './schedule-bundle/schedule-bundle.component';
import { ServiceCategoryComponent } from './service-category/service-category.component';
import { ServiceCenterComponent } from './service-center/service-center.component';

const routes: Routes = [
  { path: 'login', component: LoginComponent },
  { path: 'adminHomePage', component: AdminMainComponent },
  { path: 'serviceCenter', component: ServiceCenterComponent },
  { path: 'serviceCenter/new', component: AddServiceCenterComponent },
  { path: 'receptionistHomePage', component: ReceptionistMainComponent },
  { path: 'customer/new', component: AddCustomerComponent },
  { path: 'serviceCategories', component: ServiceCategoryComponent },
  { path: 'serviceCategory/new', component: AddServiceCategoryComponent },
  { path: 'scheduleBundles', component: ScheduleBundleComponent },
  { path: 'managerHomePage', component: ManagerHomeComponent },
  { path: 'employee/new', component: AddEmployeeComponent },
  { path: 'customerHomePage', component: CustomerHomeComponent },
  { path: 'mechanicHomePage', component: MechanicHomeComponent },
  { path: '', redirectTo: '/login', pathMatch: 'full' }
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
