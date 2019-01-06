defmodule URL.Application do
  use Application

  def start(_type, _args) do
    children = [
      {Repo, []}
      ]
    opts = [strategy: :one_for_one, name: URL.Supervisor]
    URL.Supervisor.start_link(children, opts)
  end
  
end

