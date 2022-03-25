import {VolDisplayed} from "./vol-displayed";

export interface ColumnDef{
  columnDef: string,
  header: string,
  cell: (element: VolDisplayed) => {},
}
