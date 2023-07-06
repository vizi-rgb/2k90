import { Directive } from '@angular/core';
import { AbstractControl, NG_VALIDATORS, ValidationErrors, ValidatorFn, Validator } from '@angular/forms';

export function createPasswordStrengthValidator() : ValidatorFn {
  return (control: AbstractControl) : ValidationErrors | null => {
    const password: string = control.value;    

    if (!password) {
      return null;
    }

    const hasUpperCase: boolean = /[A-Z]+/.test(password);
    const hasLowerCase: boolean = /[a-z]+/.test(password);
    const hasDigit: boolean = /[0-9]+/.test(password);
    const hasSpecialChar: boolean = /([\W]+)|([_]+)/.test(password);
    const hasNoSpaces: boolean = /^[^ ]+$/.test(password);

    const passwordValid: boolean = hasUpperCase &&
                                   hasLowerCase && 
                                       hasDigit &&
                                 hasSpecialChar &&
                                      hasNoSpaces;

    return !passwordValid ? {passwordStrengthCheck: true} : null;

  }
}

@Directive({
  selector: '[appPasswordStrength]',
  providers: [{ provide: NG_VALIDATORS, useExisting: PasswordStrengthDirective, multi: true }]
})
export class PasswordStrengthDirective implements Validator {

  validate(control: AbstractControl): ValidationErrors | null {
    return createPasswordStrengthValidator()(control);
  }
}
