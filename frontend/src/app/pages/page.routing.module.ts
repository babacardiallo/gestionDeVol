import { NgModule } from '@angular/core';
import { RouterModule } from '@angular/router';
import {VolComponent} from "./vol/vol.component";
import {VolDetailComponent} from "./vol-detail/vol-detail.component";

const routes = [
  { path: '', component: VolComponent },
  {path: ':id', component: VolDetailComponent }
];

@NgModule({
  imports: [RouterModule.forChild(routes)],
  exports: [RouterModule]
})
export class PageRoutingModule { }
