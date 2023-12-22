import { DocumentIcon, MagnifyingGlassIcon } from '@heroicons/react/24/outline'
import {
  Button,
  Input,
  Tab,
  Tabs,
  TabsHeader,
  Typography,
} from '@material-tailwind/react'

const TABS = [
  {
    label: 'Todos',
    value: 'all',
  },
  {
    label: 'Desenvolvimento',
    value: 'dev',
  },
  {
    label: 'QA',
    value: 'qa',
  },
  {
    label: 'Stage',
    value: 'stage',
  },
  {
    label: 'Produção',
    value: 'prod',
  },
]

export const TemplatesHeader = () => {
  return (
    <>
      <div className="mb-8 flex items-center justify-between gap-8">
        <div>
          <Typography variant="h5" color="blue-gray">
            Templates cadastrados
          </Typography>
          <Typography color="gray" className="mt-1 font-normal">
            Todos templates cadastrados no sistema
          </Typography>
        </div>
        <div className="flex shrink-0 flex-col gap-2 sm:flex-row">
          <Button
            className="flex items-center gap-3"
            color="blue-gray"
            size="sm"
          >
            <DocumentIcon strokeWidth={2} className="h-4 w-4" /> Cadastrar um
            novo
          </Button>
        </div>
      </div>
      <div className="flex flex-col items-center justify-between gap-4 md:flex-row">
        <Tabs value="dev" className="w-full md:w-max">
          <TabsHeader>
            {TABS.map(({ label, value }) => (
              <Tab key={value} value={value}>
                &nbsp;&nbsp;{label}&nbsp;&nbsp;
              </Tab>
            ))}
          </TabsHeader>
        </Tabs>
        <div className="w-full md:w-72">
          <Input
            label="Procurar"
            icon={<MagnifyingGlassIcon className="h-5 w-5" />}
          />
        </div>
      </div>
    </>
  )
}
