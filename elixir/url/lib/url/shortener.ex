defmodule URL.Shortener do
  def encode(url) do
    URL.Counter.increment(:counter)
    {:ok, id} = URL.Counter.get_count(:counter)
    hash = Base62.encode(id)
    URL.Bucket.put(:urls, hash, {url, 1})
  end

  def decode(hash) do
    urls = URL.Bucket.get_state(:urls)

    case Map.has_key?(urls, hash) do
      true ->
        IO.puts("found the url.")
        {url, hits} = URL.Bucket.get(:urls, hash)
        URL.Bucket.delete(:urls, hash)
        URL.Bucket.put(:urls, hash, {url, hits + 1})
        {url, hits}

      false ->
        IO.puts("this key doenst exist in the map")
    end
  end
end
