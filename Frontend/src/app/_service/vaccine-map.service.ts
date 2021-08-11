import {Injectable} from '@angular/core';
import {HttpClient} from "@angular/common/http";
import {Observable} from "rxjs";
import {environment} from "../../environments/environment";

@Injectable({
  providedIn: 'root'
})
export class VaccineMapService {

  subDivision;

  constructor(private http: HttpClient) {
  }

  addPlace(place): Observable<any> {
    return this.http.post<any>(environment.backend_url + 'place/addPlace', place);
  }

  updatePlace(placeId, place): Observable<any> {
    return this.http.put<any>(environment.backend_url + 'place/updatePlace/' + placeId, place);
  }

  removePlace(placeId): Observable<any> {
    return this.http.delete<any>(environment.backend_url + 'place/deletePlace/' + placeId);
  }

  addVaccine(vaccine): Observable<any> {
    return this.http.post<any>(environment.backend_url + 'vaccine/addVaccine', vaccine);
  }

  updateVaccine(vaccineId, vaccine): Observable<any> {
    return this.http.put<any>(environment.backend_url + 'vaccine/updateVaccine/' + vaccineId, vaccine);
  }

  removeVaccine(vaccineId): Observable<any> {
    return this.http.delete<any>(environment.backend_url + 'vaccine/deleteVaccine/' + vaccineId);
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

  getSubDivisionOfficers(): Observable<any> {
    return this.http.get<any>(environment.backend_url + 'officer/getSubDivisionOfficers');
  }

  getOfficersForSubDivision(placeId): Observable<any> {
    return this.http.get<any>(environment.backend_url + 'officer/getOfficersForSubDivision/' + placeId);
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
