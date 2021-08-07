import { environment } from './../../../environments/environment';
import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';

@Injectable({
  providedIn: 'root'
})
export class AssetService {
  private apiBase = environment.apiBase;

  constructor(private http: HttpClient) { }


  subirArchivo(form: FormData) {
    return this.http.post(`${this.apiBase}/assets/upload`, form);
  }
}
