import { Routes } from '@angular/router';
import { BlankComponent } from './layouts/blank/blank.component';
import { FullComponent } from './layouts/full/full.component';
import {ListEventComponent} from "./components/Events/list-event/list-event.component";
import {ListParticipantComponent} from "./components/Participants/list-participant/list-participant.component";
import {AppSideLoginComponent} from "./pages/authentication/side-login/side-login.component";
import {AppSideRegisterComponent} from "./pages/authentication/side-register/side-register.component";

export const routes: Routes = [
  {
    path: '',
    redirectTo: '/accueil', // Redirige vers la page d'accueil par défaut
    pathMatch: 'full',
  },
  //{
   // path: 'accueil', // Route vers la page d'accueil
  //  component: PageaccueilComponent,
  //},
  {
    path: 'login',
    component: AppSideLoginComponent, // Liste des participants
  },

  {
    path: 'inscription', // Route vers la page d'inscription
    component: AppSideRegisterComponent,
  },
  {
    path: '',
    component: FullComponent,
    children: [
      {
        path: '',
        redirectTo: '/dashboard',
        pathMatch: 'full',
      },
      {
        path: 'dashboard',
        loadChildren: () =>
          import('./pages/pages.routes').then((m) => m.PagesRoutes),
      },


      {
        path: 'event/listEvent',
        component: ListEventComponent, // Liste des participants
      },
      {
        path: 'participant/listParticipant',
        component: ListParticipantComponent, // Liste des participants
      },
      {
        path: 'extra',
        loadChildren: () =>
          import('./pages/extra/extra.routes').then((m) => m.ExtraRoutes),
      },
    ],
  },
  {
    path: '',
    component: BlankComponent,
    children: [
      {
        path: 'authentication',
        loadChildren: () =>
          import('./pages/authentication/authentication.routes').then(
            (m) => m.AuthenticationRoutes
          ),
      },
    ],
  },
  {
    path: '**',
    redirectTo: 'authentication/error',
  },

];
