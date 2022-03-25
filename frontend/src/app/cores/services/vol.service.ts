import { Injectable } from '@angular/core';
import {CommunicationService} from "./communication.service";
import {Observable} from "rxjs";
import {Vol} from "../../models/vol";
import {VolSearchFilter} from "../../models/vol-search-filter";
import {VolDisplayed} from "../../models/vol-displayed";
import {ColumnDef} from "../../models/column-def";

@Injectable()
export class VolService {

  constructor(private communicationService: CommunicationService) { }

  executeAction(): ColumnDef[] {
    return [
      {
        columnDef: 'identifiant',
        header: 'ID.',
        cell: (element: VolDisplayed) => `${element.indentifiant}`,
      },
      {
        columnDef: 'lieuDepart',
        header: 'Lieu depart',
        cell: (element: VolDisplayed) => `${element.lieuDepart}`,
      },
      {
        columnDef: 'lieuArrive',
        header: 'Lieu Arrivee',
        cell: (element: VolDisplayed) => `${element.lieuArrive}`,
      },
      {
        columnDef: 'dateDepart',
        header: 'Date depart',
        cell: (element: VolDisplayed) => `${element.dateDepart}`,
      },
      {
        columnDef: 'heureDepart',
        header: 'Heure depart',
        cell: (element: VolDisplayed) => `${element.heureDepart}`,
      },
      {
        columnDef: 'dateArrive',
        header: 'Date arrivee',
        cell: (element: VolDisplayed) => `${element.dateArrive}`,
      },
      {
        columnDef: 'heureArrive',
        header: 'Heure arrivee',
        cell: (element: VolDisplayed) => `${element.heureArrive}`,
      },
      {
        columnDef: 'nbrEscales',
        header: 'Nombre escales',
        cell: (element: VolDisplayed) => `${element.nbrEscales}`,
      },
      {
        columnDef: 'prix',
        header: 'Prix',
        cell: (element: VolDisplayed) => `${element.prix}`,
      },

      {
        columnDef: 'action',
        header: '',
        cell: (element: VolDisplayed) => ``,
      },

    ]
  }

  public getAllVol(searchParam: VolSearchFilter): Observable<Vol[]>{
    return this.communicationService.posElement("vol/getAllVols", searchParam);
  }
  public getVolById(id: number): Observable<Vol>{
    return this.communicationService.getElementById("vol", id);
  }

  public convertToDisplayVol(vol: any): VolDisplayed[] {

    const volDisplay: VolDisplayed[] = [];

    vol.data.forEach((el: VolDisplayed) => {
      volDisplay.push(
        {

          indentifiant: el.indentifiant,

          prix: el.prix,

          dateDepart: el.dateDepart,

          heureDepart: el.heureDepart,

          dateArrive: el.dateArrive,

          heureArrive: el.heureArrive,

          lieuDepart: el.lieuDepart,

          lieuArrive: el.lieuArrive,

          nbrEscales: el.nbrEscales
        }
      )
    })
    return volDisplay;
  }
}
