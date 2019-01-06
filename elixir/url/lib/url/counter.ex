defmodule URL.Counter do
  use Agent, restart: :temporary

  def start_link(_opts) do
    Agent.start_link(fn -> %{count: 1} end, name: :counter)
  end

  def get_count(bucket) do
    Agent.get(bucket, &Map.fetch(&1, :count))
  end

  def increment(bucket) do
    {:ok, value} = get_count(bucket)
    Agent.update(bucket, &Map.put(&1, :count, value + 1))
  end
end
