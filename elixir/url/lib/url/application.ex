defmodule URL.Application do
  use Application

  def start(_type, _args) do
    children = [
      {URL.Bucket, name: URL.Bucket},
      {URL.Counter, name: URL.Counter},
      {Repo, []}
    ]

    opts = [strategy: :one_for_one, name: URL.Supervisor]
    Supervisor.start_link(children, opts)
  end
end
