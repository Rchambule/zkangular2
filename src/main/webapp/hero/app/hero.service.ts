import { Injectable }    from '@angular/core';
import { Headers, Http } from '@angular/http';

import 'rxjs/add/operator/toPromise';

import { Hero } from './hero';

declare var zkbind:any;

@Injectable()
export class HeroService {

  private headers = new Headers({'Content-Type': 'application/json'});
  private heroesUrl = 'app/heroes';  // URL to web api
  private binder = zkbind.$('$heroes');

  constructor(private http: Http) { }

  getHeroes(): void {
//    return this.http.get(this.heroesUrl)
//               .toPromise()
//               .then(response => response.json().data as Hero[])
//               .catch(this.handleError);
    this.binder.command('reload');     
  }

  getHero(id: number): void {
//    return this.getHeroes()
//               .then(heroes => heroes.find(hero => hero.id === id));
    this.binder.command('reload', {'id':id}); 
  }

  delete(id: number): void {
//    const url = `${this.heroesUrl}/${id}`;
//    return this.http.delete(url, {headers: this.headers})
//      .toPromise()
//      .then(() => null)
//      .catch(this.handleError);
    this.binder.command('delete', {'id':id}); 
  }

  create(name: string): void {
//    return this.http
//      .post(this.heroesUrl, JSON.stringify({name: name}), {headers: this.headers})
//      .toPromise()
//      .then(res => res.json().data)
//      .catch(this.handleError);
    this.binder.command('add', {'name':name});    
  }

  update(hero: Hero): void {
    this.binder.command('update', {'hero':hero});      
//    const url = `${this.heroesUrl}/${hero.id}`;
//    return this.http
//      .put(url, JSON.stringify(hero), {headers: this.headers})
//      .toPromise()
//      .then(() => hero)
//      .catch(this.handleError);
  }

//  private handleError(error: any): Promise<any> {
//    console.error('An error occurred', error); // for demo purposes only
//    return Promise.reject(error.message || error);
//  }
}



/*
Copyright 2016 Google Inc. All Rights Reserved.
Use of this source code is governed by an MIT-style license that
can be found in the LICENSE file at http://angular.io/license
*/