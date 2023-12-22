import { Outlet } from 'react-router-dom'

import { Header } from '@components/header/header'

export const DefaultLayout = () => {
  return (
    <div className="min-h-full">
      <Header />
      <Outlet />
    </div>
  )
}
