import { Route, Routes } from 'react-router-dom'

import { DefaultLayout } from '@layouts/default-layout/DefaultLayout'

// import { Home } from './pages/home/Home'
import { Templates } from './pages/templates/Templates'
// import { Domains } from './pages/domains/Domains'

export const Router = () => (
  <Routes>
    <Route path="/" element={<DefaultLayout />}>
      <Route path="/" element={<Templates />} />

      {/* <Route path="/" element={<Home />} /> */}
      {/* <Route path="/domains" element={<Domains />} /> */}
      {/* <Route path="/templates" element={<Templates />} /> */}
    </Route>
  </Routes>
)
