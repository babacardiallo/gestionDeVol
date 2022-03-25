import {PageDto} from "./page-dto";

export interface VolSearchFilter{

  prix?: number;

  dateDepart?: Date;

  dateArrive?: Date;

  lieuDepart?: string;

  lieuArrive?: string;

  haveEscale?: boolean;

  pageDto?: PageDto;
}
