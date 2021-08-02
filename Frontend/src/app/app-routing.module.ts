import {NgModule} from '@angular/core';
import {RouterModule, Routes} from '@angular/router';
import {VaccineMapComponent} from "./vaccine-map/vaccine-map.component";
import {LoginComponent} from "./login/login.component";
import {ContComponent} from "./cont/cont.component";
import {NavComponent} from "./nav/nav.component";
import {SignupComponent} from "./signup/signup.component";

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
    path: 'signup',
    component: SignupComponent,
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
