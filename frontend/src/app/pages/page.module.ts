import { NgModule } from '@angular/core';
import {VolComponent} from "./vol/vol.component";
import {LayoutModule} from "../layouts/layout.module";
import {CommonModule} from "@angular/common";
import {MatButtonModule} from "@angular/material/button";
import {RouterModule} from "@angular/router";
import {VolDetailComponent} from "./vol-detail/vol-detail.component";
import {PageRoutingModule} from "./page.routing.module";

@NgModule({
  declarations: [
    VolComponent
  ],
  imports: [
    LayoutModule,
    CommonModule,
    MatButtonModule,
    PageRoutingModule
  ],
  exports: [
    VolComponent
  ],
  providers: [],
})
export class PageModule { }
