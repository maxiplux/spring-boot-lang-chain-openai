import {ApplicationConfig, importProvidersFrom, provideZoneChangeDetection} from '@angular/core';
import { provideRouter } from '@angular/router';
import { provideHttpClient, withInterceptors } from '@angular/common/http';
import { routes } from './app.routes';
import {AngularFireModule} from "@angular/fire/compat";
import {environment} from "../environments/environment";


import { authInterceptor } from './interceptors/auth.interceptor';
import {tokenInterceptor} from './interceptors/token.interceptor';

export const appConfig: ApplicationConfig = {
  providers: [provideZoneChangeDetection({ eventCoalescing: true }),
    importProvidersFrom(AngularFireModule.initializeApp(environment.firebase)),
    provideHttpClient(withInterceptors([tokenInterceptor,authInterceptor])),
    provideRouter(routes)]
};
