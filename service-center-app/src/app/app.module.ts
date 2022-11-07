import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';

import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { LoginComponent } from './login/login.component';
import { NgxLoadingModule } from 'ngx-loading';
import { FormsModule } from '@angular/forms';
import { BrowserAnimationsModule } from '@angular/platform-browser/animations';
import { MatFormFieldModule } from '@angular/material/form-field';
import { MatInputModule } from '@angular/material/input';
import { HttpClientModule, HttpClient } from '@angular/common/http';
import { MatButtonModule } from '@angular/material/button';
import { AdminMainComponent } from './admin-main/admin-main.component';
import { MatTableModule } from '@angular/material/table';
import { MatToolbarModule } from '@angular/material/toolbar';
import { MatIconModule } from '@angular/material/icon';
import { ServiceCenterComponent } from './service-center/service-center.component';
import { MatSnackBarModule } from '@angular/material/snack-bar';
import { AddServiceCenterComponent } from './add-service-center/add-service-center.component';
import { MatCheckboxModule } from '@angular/material/checkbox';
import { ReceptionistMainComponent } from './receptionist-main/receptionist-main.component';
import { AddCustomerComponent } from './add-customer/add-customer.component';
import { MatSelectModule } from '@angular/material/select';
import { ServiceCategoryComponent } from './service-category/service-category.component';
import { AddEmployeeComponent } from './add-employee/add-employee.component';
import { EmployeeDetailsComponent } from './employee-details/employee-details.component';
import { AddServiceCategoryComponent } from './add-service-category/add-service-category.component';
import { ScheduleBundleComponent } from './schedule-bundle/schedule-bundle.component';
import { ManagerHomeComponent } from './manager-home/manager-home.component';
import { MatSlideToggleModule } from '@angular/material/slide-toggle';
import { CustomerHomeComponent } from './customer-home/customer-home.component';
import { MechanicHomeComponent } from './mechanic-home/mechanic-home.component';
import { AddCustomerCarComponent } from './add-customer-car/add-customer-car.component';

@NgModule({
  declarations: [
    AppComponent,
    LoginComponent,
    AdminMainComponent,
    ServiceCenterComponent,
    AddServiceCenterComponent,
    ReceptionistMainComponent,
    AddCustomerComponent,
    ServiceCategoryComponent,
    AddEmployeeComponent,
    EmployeeDetailsComponent,
    AddServiceCategoryComponent,
    ScheduleBundleComponent,
    ManagerHomeComponent,
    CustomerHomeComponent,
    MechanicHomeComponent,
    AddCustomerCarComponent
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    FormsModule,
    NgxLoadingModule.forRoot({}),
    BrowserAnimationsModule,
    MatFormFieldModule,
    MatInputModule,
    HttpClientModule,
    MatButtonModule,
    MatTableModule,
    MatToolbarModule,
    MatIconModule,
    MatSnackBarModule,
    MatCheckboxModule,
    MatSelectModule,
    MatSlideToggleModule
  ],
  providers: [HttpClient],
  bootstrap: [AppComponent]
})
export class AppModule { }
