import {NgModule} from '@angular/core';
import {RouterModule, Routes} from '@angular/router';
import {VaccineMapComponent} from "./vaccine-map/vaccine-map.component";
import {LoginComponent} from "./login/login.component";
import {ContComponent} from "./cont/cont.component";
import {NavComponent} from "./nav/nav.component";
import {SignupComponent} from "./signup/signup.component";
import {ManageVaccineComponent} from "./manage-vaccine/manage-vaccine.component";
import {ManagePlacesComponent} from "./manage-places/manage-places.component";
import {ManageVaccinesComponent} from "./manage-vaccines/manage-vaccines.component";
import {MainOfficerComponent} from "./main-officer/main-officer.component";
import {ManageOfficersComponent} from "./manage-officers/manage-officers.component";

const routes: Routes = [
  {
    path: '',
    redirectTo: 'map',
    pathMatch: 'full'
  },
  {
    path: 'map',
    component: VaccineMapComponent,
  },
  {
    path: 'token',
    component: ManageVaccineComponent,
  },
  {
    path: 'signup',
    component: SignupComponent,
  },
  {
    path: 'manage_places',
    component: ManagePlacesComponent,
  },
  {
    path: 'manage_vaccines',
    component: ManageVaccinesComponent,
  },
  {
    path: 'officers',
    component: MainOfficerComponent,
  },
  {
    path: 'manage_officers',
    component: ManageOfficersComponent,
  },
  {
    path: 'login',
    component: LoginComponent,
  },
  {
    path: 'cont',
    component: ContComponent,
  },
  {
    path: 'nav',
    component: NavComponent,
    children: [
      {
        path: 'cont',
        component: ContComponent,
      },
      {
        path: 'login',
        component: LoginComponent,
      }
    ]
  },
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule {
}
