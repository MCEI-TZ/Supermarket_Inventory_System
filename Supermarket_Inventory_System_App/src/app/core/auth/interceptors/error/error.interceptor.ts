import { inject } from '@angular/core';
import { HttpErrorResponse, HttpHandlerFn, HttpRequest } from '@angular/common/http';
import { ToastService } from '../../services/toast/toast.service.ts.service';
import { catchError, throwError } from 'rxjs';

export function errorInterceptor(
  request: HttpRequest<unknown>,
  next: HttpHandlerFn
)  {
const toast = inject(ToastService);

  return next(request).pipe(
    catchError((error: HttpErrorResponse) => {
      if(error.status === 0){
        toast.showError('Network error. Please check your internet connection.');
      }else{
        const message = error.error?.message || error.message;
        toast.showError(message, `Error ${error.status}`);
      }
      return throwError(() => error);
    })
  )
};
