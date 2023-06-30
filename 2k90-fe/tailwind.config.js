/** @type {import('tailwindcss').Config} */
module.exports = {
  content: ["./src/**/*.{html,js,ts}"],
  theme: {
    extend: {
      fontFamily: {
        'urbanist': ['Urbanist', 'sans-serif'],
        'titillium': ['Titillium Web', 'sans-serif']
      },

      colors: {
      'bg': '#030820',
      'color-1': '#31FC6A',
      'color-2': '#3A1078',
      'color-3': '#97ACCC',
      'color-4': '#D9D9D9',
      },
    },
  },
  plugins: [],
}

