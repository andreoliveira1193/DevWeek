import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { Faixaetaria } from '../model/faixaetaria';

@Injectable({
  providedIn: 'root'
})
export class FaixaetariaService {

  constructor(private http: HttpClient) { }

  listFaixaEtaria(): Observable<Faixaetaria[]>{
    //const url = '/assets/faixaetaria.json'
    const url = '/api/faixaetaria'
    return this.http.get<Faixaetaria[]>(url);
  }


}
