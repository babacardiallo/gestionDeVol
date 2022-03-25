import {Escale} from "./escale";

export interface Vol{

  indentifiant?: number;

  prix?: number;

  dateDepart?: string;

  heureDepart?: string;

  dateArrive?: string;

  heureArrive?: string;

  lieuDepart?: string;

  lieuArrive?: string;

  nbrEscales?: number;

  escales?: Array<Escale>;

}
