import {Injectable} from '@angular/core';

@Injectable({
  providedIn: 'root'
})
export class UtilService {
  constructor() {
  }

  urlFormatter(text: string): string {
    const wrongCharacters = ['ş', 'ı', 'ü', 'ö', 'ç', 'ğ', 'Ş', 'İ', 'Ü', 'Ö', 'Ç', 'Ğ']
    const trueCharacters = ['s', 'i', 'u', 'o', 'c', 'g', 'S', 'I', 'U', 'O', 'C', 'G']
    wrongCharacters.forEach(function (value, index) {
      text = text.split(value).join(trueCharacters[index]);
    });
    text = text.toLowerCase();
    text = text.replace(/[^A-Za-z0-9]/g, '-');
    return text;
  }
}
