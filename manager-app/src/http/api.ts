import axios from 'axios'

const ENV = {
  BASE_URL: import.meta.env.VITE_API_BASE_URL,
}

export const api = axios.create({
  baseURL: ENV.BASE_URL,
})
