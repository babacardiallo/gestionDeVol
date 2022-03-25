import { Injectable } from '@angular/core';
import {HttpClient} from "@angular/common/http";
import {SERVER_URL} from "../../../assets/URL";
import {Observable} from "rxjs";

@Injectable({
  providedIn: 'root'
})
export class CommunicationService {

  constructor(private http: HttpClient) {
  }

  public getElement(path: string): Observable<any> {
    return this.http.get(SERVER_URL + path);
  }

  public posElement(path: string, data: any): Observable<any> {
    return this.http.post(SERVER_URL + path, data);
  }

  public getElementById(path: string, id: number): Observable<any> {
    return this.http.get(SERVER_URL + path + '/' + id);
  }
}
