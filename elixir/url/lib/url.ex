defmodule URL do
  use Application

  @moduledoc """
  Documentation for URL.
  """

  @doc """
  Hello world.

  ## Examples

      iex> URL.hello
      :world

  """
  def hello do
    :world
  end

  def start(_type, _args) do
    URL.Supervisor.start_link(name: URL.Supervisor)
  end
  
end

