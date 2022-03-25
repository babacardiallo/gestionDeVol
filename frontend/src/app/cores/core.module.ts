import { NgModule } from '@angular/core';
import {LieuService} from "./services/lieu.service";
import {VolService} from "./services/vol.service";
import {HttpClientModule} from "@angular/common/http";


@NgModule({
  declarations: [],
  imports: [HttpClientModule],
  providers: [LieuService, VolService],
})
export class CoreModule { }
