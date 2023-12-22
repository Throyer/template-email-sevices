import react from '@vitejs/plugin-react'
import tsconfigPaths from 'vite-tsconfig-paths'

import { defineConfig, loadEnv } from 'vite'

// https://vitejs.dev/config/
export default ({ mode }) => {
  process.env = { ...process.env, ...loadEnv(mode, process.cwd()) }
  return defineConfig({
    plugins: [react(), tsconfigPaths()],
    server: {
      port: Number(process.env.APP_PORT || 3000),
    },
  })
}