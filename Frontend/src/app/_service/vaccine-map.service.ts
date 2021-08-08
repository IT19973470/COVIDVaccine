import {Injectable} from '@angular/core';
import {HttpClient} from "@angular/common/http";
import {Observable} from "rxjs";
import {environment} from "../../environments/environment";

@Injectable({
  providedIn: 'root'
})
export class VaccineMapService {

  subDivisionId;

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

  getProvinces(): Observable<any> {
    return this.http.get<any>(environment.backend_url + 'place/getProvinces');
  }

  getDistricts(provinceId): Observable<any> {
    return this.http.get<any>(environment.backend_url + 'place/getDistricts/' + provinceId);
  }

  getSubDivisions(districtId): Observable<any> {
    return this.http.get<any>(environment.backend_url + 'place/getSubDivisions/' + districtId);
  }

  getVaccinatedCountForSubDivision(districtId): Observable<any> {
    return this.http.get<any>(environment.backend_url + 'patient/getVaccinatedCountForSubDivision/' + districtId + '/30');
  }

  getPlaces(subDivisionId): Observable<any> {
    return this.http.get<any>(environment.backend_url + 'place/getPlaces/' + subDivisionId);
  }

  getPatientsForPlace(subDivisionId, tokenType, age): Observable<any> {
    return this.http.get<any>(environment.backend_url + 'patient/getPatientsForPlace/' + subDivisionId + '/' + tokenType + '/' + age);
  }

  getVaccines(): Observable<any> {
    return this.http.get<any>(environment.backend_url + 'vaccine/getVaccines');
  }

  getPatientsCountForPlace(subDivisionId, tokenType): Observable<any> {
    return this.http.get<any>(environment.backend_url + 'patient/getPatientsCountForPlace/' + subDivisionId + '/' + tokenType);
  }

}
