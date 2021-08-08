import {NgModule} from '@angular/core';
import {BrowserModule} from '@angular/platform-browser';

import {AppRoutingModule} from './app-routing.module';
import {AppComponent} from './app.component';
import {VaccineMapComponent} from './vaccine-map/vaccine-map.component';
import {LoginComponent} from './login/login.component';
import {SignupComponent} from './signup/signup.component';
import {FormsModule, ReactiveFormsModule} from "@angular/forms";
import {ContComponent} from './cont/cont.component';
import {NavComponent} from './nav/nav.component';
import {ManageVaccineComponent} from './manage-vaccine/manage-vaccine.component';
import {HttpClientModule} from "@angular/common/http";
import { ManagePlacesComponent } from './manage-places/manage-places.component';
import { ManageVaccinesComponent } from './manage-vaccines/manage-vaccines.component';

@NgModule({
  declarations: [
    AppComponent,
    VaccineMapComponent,
    LoginComponent,
    SignupComponent,
    ContComponent,
    NavComponent,
    ManageVaccineComponent,
    ManagePlacesComponent,
    ManageVaccinesComponent
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    FormsModule,
    HttpClientModule
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule {
}
