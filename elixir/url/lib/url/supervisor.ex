defmodule URL.Supervisor do
  use Supervisor

  def start_link(_children, opts) do
    Supervisor.start_link(__MODULE__, :ok, opts)
  end

  def init(:ok) do
    children = [
      {URL.Bucket, name: URL.Bucket},
      {URL.Counter, name: URL.Counter},
      {Repo, []}
    ]
    Supervisor.init(children, strategy: :one_for_all)
    # supervise(children, strategy: :one_for_one)
  end

end

