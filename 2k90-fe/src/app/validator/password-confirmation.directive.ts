import { Directive, Input } from '@angular/core';
import { AbstractControl, NG_VALIDATORS, ValidationErrors, Validator, ValidatorFn } from '@angular/forms';

export function createPasswordConfirmationValidator(password: string | null) : ValidatorFn {
  return (control: AbstractControl) : ValidationErrors | null => {
    const passwordConfirmation: string = control.value;

    if (!passwordConfirmation) {
      return null;
    }

    const passwordConfirmationDiffers: boolean = password != passwordConfirmation;

    return passwordConfirmationDiffers ? {passwordConfirmationDiffers: true} : null;
  }
}

@Directive({
  selector: '[appPasswordConfirmation]',
  providers: [{ provide: NG_VALIDATORS, useExisting: PasswordConfirmationDirective,
  multi: true }],
})
export class PasswordConfirmationDirective implements Validator {

  @Input('appPasswordConfirmation') password!: string | null;

  validate(control: AbstractControl): ValidationErrors | null {
    return createPasswordConfirmationValidator(this.password)(control);
  }


}
