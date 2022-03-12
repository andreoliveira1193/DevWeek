import { Injectable } from '@angular/core';
import { Regiao } from '../model/regiao';
import { Observable } from 'rxjs';
import { HttpClient } from '@angular/common/http';

@Injectable({
  providedIn: 'root'
})
export class RegiaoService {

  constructor(private http:HttpClient) { }
    
    listRegioes(): Observable<Regiao[]> {
      //const url = '/assets/regiao.json';
      const url = '/api/regiao';
      return this.http.get<Regiao[]>(url);
    }
  }

