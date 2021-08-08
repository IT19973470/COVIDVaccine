import { NgModule } from '@angular/core';
import { PreloadAllModules, RouterModule, Routes } from '@angular/router';
import {VaccineMapComponent} from "./vaccine-map/vaccine-map.component";
import {SignupComponent} from "./signup/signup.component";


const routes: Routes = [
  {
    path: '',
    redirectTo: 'vaccine',
    pathMatch: 'full'
  },
  {
    path: 'signup',
    component: SignupComponent,
  },
  // {
  //   path: 'folder/:id',
  //   loadChildren: () => import('./folder/folder.module').then( m => m.FolderPageModule)
  // },
  {
    path:'vaccine',
    component:VaccineMapComponent
  }
];

@NgModule({
  imports: [
    RouterModule.forRoot(routes, { preloadingStrategy: PreloadAllModules })
  ],
  exports: [RouterModule]
})
export class AppRoutingModule {}
