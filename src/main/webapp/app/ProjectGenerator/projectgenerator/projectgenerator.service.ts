import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';

@Injectable({
  providedIn: 'root',
})
export class ProjectgeneratorService {
  private baseUrl = 'http://localhost:7777';

  constructor(private http: HttpClient) {}

  generateProject(payload: any): Observable<any> {
    const headers = {
      'Content-Type': 'application/json',
      // 'Authorization' : "hdjwd" //
    };
    return this.http.post(`${this.baseUrl}/call-download`, payload, { headers, responseType: 'blob' });
  }
}
