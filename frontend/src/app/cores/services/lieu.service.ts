import { Injectable } from '@angular/core';
import {CommunicationService} from "./communication.service";
import {VolSearchFilter} from "../../models/vol-search-filter";
import {Observable} from "rxjs";
import {Vol} from "../../models/vol";

@Injectable()
export class LieuService {

  constructor(private communicationService: CommunicationService) {

  }

  public getAllLieu(): Observable<string[]>{
    return this.communicationService.getElement("lieu/all");
  }

}
