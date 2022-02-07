import {Injectable} from '@angular/core';
import {HttpClient} from "@angular/common/http";
import {Observable} from "rxjs";
import {environment} from "../../environments/environment";

@Injectable({
  providedIn: 'root'
})
export class PatientService {

  constructor(private http: HttpClient) {
  }

  addPatient(patient): Observable<any> {
    return this.http.post<any>(environment.backend_url + 'patient/addPatient', patient);
  }

  updatePatient(patient): Observable<any> {
    return this.http.post<any>(environment.backend_url + 'patient/updatePatient/' + patient.patientId, patient);
  }

  removePatient(patientId): Observable<any> {
    return this.http.delete<any>(environment.backend_url + 'patient/deletePatient/' + patientId);
  }

  getInstitutes(userId): Observable<any> {
    return this.http.get<any>(environment.backend_url + 'institute/admin/getInstitutesViaUser/' + userId);
  }

  addVaccineToken(vaccineToken): Observable<any> {
    return this.http.post<any>(environment.backend_url + 'token/addToken', vaccineToken);
  }

  removeVaccineToken(tokenId): Observable<any> {
    return this.http.delete<any>(environment.backend_url + 'token/deleteToken/' + tokenId);
  }

  vaccinateMe(patientId): Observable<any> {
    return this.http.get<any>(environment.backend_url + 'patient/vaccinateMe/' + patientId);
  }

  getMyVaccines(nic): Observable<any> {
    return this.http.get<any>(environment.backend_url + 'token/getMyVaccines/' + nic);
  }
}
