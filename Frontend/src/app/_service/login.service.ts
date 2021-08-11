import {Injectable} from '@angular/core';
import {Observable} from "rxjs";
import {environment} from "../../environments/environment";
import {HttpClient} from "@angular/common/http";

@Injectable({
  providedIn: 'root'
})
export class LoginService {

  constructor(private http: HttpClient) {
  }

  login(officer): Observable<any> {
    return this.http.post<any>(environment.backend_url + 'officer/login', officer);
  }

  addOfficer(officer): Observable<any> {
    return this.http.post<any>(environment.backend_url + 'officer/addOfficer', officer);
  }

  addSubDivisionOfficer(subDivisionOfficer): Observable<any> {
    return this.http.post<any>(environment.backend_url + 'officer/addSubDivisionOfficer', subDivisionOfficer);
  }

  removeSubDivisionOfficer(subDivisionId, officerId): Observable<any> {
    return this.http.delete<any>(environment.backend_url + 'officer/deleteSubDivisionOfficer/' + subDivisionId + '/' + officerId);
  }

  updateOfficer(officerId, officer): Observable<any> {
    return this.http.put<any>(environment.backend_url + 'officer/updateOfficer/' + officerId, officer);
  }

  removeOfficer(officerId): Observable<any> {
    return this.http.delete<any>(environment.backend_url + 'officer/deleteOfficer/' + officerId);
  }

  getOfficers(): Observable<any> {
    return this.http.get<any>(environment.backend_url + 'officer/getSubDivisionOfficers');
  }
}
